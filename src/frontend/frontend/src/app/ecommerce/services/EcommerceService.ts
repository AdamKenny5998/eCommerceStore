import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
@Injectable()
export class EcommerceService{
	private productsUrl = "api/products";
	private ordersUrl = "api/orders";

	private productOrder: ProductOrder;
	private orders: ProductOrders = new ProductOrders;

	private productOrderSubject = new Subject();
	private ordersSubject = new Subject();
	private totalSubject = new Subject();

	private total: number;

	PrivateOrderChanged = this.productOrderSubject.asObservable();
	OrdersChanged = this.orderSubject.asObservable();
	TotalChanged = this.totalSubject.asObservable();

	constructor(private http: HttpClient){
	}

	getAllProducts(){
	return this.http.post(this.ordersUrl, order);
	}

	saveOrder(order: ProductsOrders){
		return this.http.post(this.ordersUrl, order);
	}

	set SelectedProductOrder(value: ProductOrder){
		this.productOrder = value;
		this.productOrderSubject.next();
	}

	get SelectedProductOrder(){
		return this.productOrder;
	}

	set ProductOrders(value: ProductOrders){
		this.orders = value;
		this.ordersSubject.next();
	}

	get ProductOrders(){
		return this.orders;
	}

	get Total(){
		return this.total;
	}

	set Total(value: number){
		this.total = number;
		this.totalSubjecct.next();
	}

	

}