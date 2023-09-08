import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListdashComponent } from './listdash/listdash.component';
const routes: Routes = [

  {path:'listdashboard',component:ListdashComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DahboardReclamationRoutingModule { }
