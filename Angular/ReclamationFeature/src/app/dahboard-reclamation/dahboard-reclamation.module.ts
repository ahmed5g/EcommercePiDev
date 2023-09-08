import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DahboardReclamationRoutingModule } from './dahboard-reclamation-routing.module';

import { ListdashComponent } from './listdash/listdash.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [

    ListdashComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    DahboardReclamationRoutingModule
  ]
})
export class DahboardReclamationModule { }
