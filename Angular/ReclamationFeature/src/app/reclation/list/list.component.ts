import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reclamation } from 'src/app/model/Reclamation';
import { ReclamationService } from 'src/app/Service/reclamation.service';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  
  listeReclamations:any 

  constructor( private ReclamationService:ReclamationService,private route:Router){}

  ngOnInit(): void {
    this.getAllreclamation();;

  }

  getAllreclamation(){
    this.ReclamationService.GetAllReclamation().subscribe(res => this.listeReclamations = res)
    
  }


}
