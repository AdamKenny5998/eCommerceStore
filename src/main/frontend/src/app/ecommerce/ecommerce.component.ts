import {Component, OnInit, ViewChild} from '@angular/core';
import {ProductsComponent} from './products/products.component';
import {OrdersComponent} from './orders/orders.component';
import {ShoppingCartComponent} from './shopping-cart/shopping-cart.component';

@Component({
  selector: 'app-ecommerce',
  templateUrl: './ecommerce.component.html',
  styleUrls: ['./ecommerce.component.css']
})

export class EcommerceComponent implements OnInit {
  public collapsed = true;
  orderFinished = false;

  @ViewChild('productsC')
  productsC: ProductsComponent;

  @ViewChild('shoppingCartC')
  shoppingCartC: ShoppingCartComponent;

  @ViewChild('ordersC')
  ordersC: OrdersComponent;

  toggleCollapsed(): void {
    this.collapsed = !this.collapsed;
  }

  finishedOrder(orderFinished: boolean) {
    this.orderFinished = orderFinished;
  }

  reset() {
    this.orderFinished = false;
    this.productsC.reset();
    this.shoppingCartC.reset();
    this.ordersC.paid = false;
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
