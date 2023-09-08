import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReclationRoutingModule } from './reclation-routing.module';
import { ListComponent } from './list/list.component';
import { AddComponent } from './add/add.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    ListComponent,
    AddComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReclationRoutingModule
  ]
})
export class ReclationModule { }
