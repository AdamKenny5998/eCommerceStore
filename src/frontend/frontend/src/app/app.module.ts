import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EcommerceComponent } from './ecommerce/ecommerce.component';
import { ProductsComponent } from './ecommerce/products/products.component';
import { OrdersComponent } from './ecommerce/orders/orders.component';
import { ShoppingCartComponent } from './ecommerce/shopping-cart/shopping-cart.component';

@NgModule({
  declarations: [
    AppComponent,
    EcommerceComponent,
    ProductsComponent,
    OrdersComponent,
    ShoppingCartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

export class Product {
	id: number;
	name: string;
	price: number;
	pictureUrl: string;
	
	public Product(id, name, price, pictureUrl){
		this.id = id;
		this.name = name;
		this.price = price;
		this.pictureUrl = pictureUrl;
	}
}

export class ProductOrder{
	product: Product;
	quantity: number;
	
	public ProductOrder(Product, quantity){
		this.Product = Product;
		this.quantity = quantity;
	}
}

export classs ProductOrders{
	productOrders: ProductOrder[] = [];
}


