import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReclamationService } from 'src/app/Service/reclamation.service';
import { Reclamation } from './../../model/Reclamation';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  
  reclamation: Reclamation = new Reclamation();

  constructor( private ReclamationService:ReclamationService,private router:Router){}

  ngOnInit(): void {
   

  }

  // getAllreclamation(){
  //   this.ReclamationService.GetAllReclamation().subscribe(res => this.listeReclamations = res)
    
  // }

  addReclamation() {
    this.ReclamationService.AddReclamation(this.reclamation).subscribe(
      (response) => {
        console.log('Reclamation ajoutée avec succès', response);
        // Redirigez l'utilisateur vers une autre page ou effectuez d'autres actions après avoir ajouté la réclamation.
        this.router.navigate(['/reclamations']);
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de la réclamation', error);
        // Gérez les erreurs ici.
      }
    );
  }


}
