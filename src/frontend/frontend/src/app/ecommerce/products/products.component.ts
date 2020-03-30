import {Component, OnInit} from '@angular/core';
import {ProductOrder} from "../models/product-order.model";
import {EcommerceService} from "../models/EcommerceService";
import {Subscription}

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor() { }

  ngOnInit(){
		this.productOrdesr = [];
		this.loadProducts();
		this.loadOrders();
	}

	loadProducts(){
		this.ecommerceService.getAllProducts()
		.subscribe(
			(products: any[] =>{
				this.products = products;
				this.products.forEach(product => {
					this.productOrders.push(new ProductOrder(product, 0));
					})
			},
			(error) = console.log(error)
		);
	}

	loadOrders(){
		this.sub = this.ecommerceService.OrdersChanged.subscribe(() =>{
			this.shoppingCartOrders = this.ecommerceService.ProductOrders;
			});
	}

	addToCart(order: ProductOrder){
		this.ecommerceService.SelectedProductOrder = order;
		this.selectedProductOrder = this.ecommerceService.SelectedProductOrder;
		this.productSelected = true;

	}

	removeFromCart(productOrder: ProductOrder){
		let index = this.getProductIndex(productOrder.product);
		if(index > -1){
			this.shoppingCartOrders.productOrders.splice(
				this.getProductIndex(productOrder.product), 1);
		}
		this.ecommerceService.ProductOrders = this.shoppingCartOrders;
		this.shoppingCartOrders = this.ecommerceService.ProductOrders;
		this.productSelected = false;
	}

	reset(){
		this.productOrders = [];
		this.loadProducts();
		this.ecommerceService.ProductOrders.productOrders = [];
		this.loadOrders();
		this.productSelected = false;
	}

}
