import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
{path:"reclamation",loadChildren:()=>import('./reclation/reclation.module').then(mod =>mod.ReclationModule)},
{path:"dashboard",loadChildren:()=>import('./dahboard-reclamation/dahboard-reclamation.module').then(t =>t.DahboardReclamationModule)}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
