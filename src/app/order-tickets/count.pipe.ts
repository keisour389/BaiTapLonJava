import { Pipe, PipeTransform } from '@angular/core';
import { OrderTicketsComponent } from './order-tickets.component';
@Pipe({ name: 'count' })
export class CountPipe implements PipeTransform {
    constructor(public orderTicketsComponent: OrderTicketsComponent) {
    }
    transform(value: any) {
        value = this.orderTicketsComponent.countNumber() + 1;
        return value;
    }
}