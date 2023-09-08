import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reclamation } from 'src/app/model/Reclamation';
import { ReclamationService } from 'src/app/Service/reclamation.service';
import { FormsModule } from '@angular/forms'; // Importez FormsModule


@Component({
  selector: 'app-listdash',
  templateUrl: './listdash.component.html',
  styleUrls: ['./listdash.component.css']
})
export class ListdashComponent implements OnInit {
  
  listeReclamations:any ;
  searchKeyword: string = '';

  constructor( private ReclamationService:ReclamationService,private route:Router){}

  ngOnInit(): void {
    this.getAllreclamation();;

  }

  getAllreclamation(){
    this.ReclamationService.GetAllReclamation().subscribe(res => this.listeReclamations = res)
    
  }

  updateReclamation(reclamation: Reclamation) {
    reclamation.status = 'approuver'; // Mettez à jour le statut de la réclamation

    this.ReclamationService.updateReclamation(reclamation).subscribe(
      () => {
        console.log('Réclamation approuvée avec succès');
        // Vous pouvez également mettre à jour la liste des réclamations ici si nécessaire.
        this.getAllreclamation(); // Mettez à jour la liste des réclamations après la mise à jour.
      },
      error => {
        console.error('Erreur lors de l\'approbation de la réclamation', error);
        // Gérez les erreurs ici.
      }
    );
  } 
  performSearch() {
    this.ReclamationService.searchReclamation(this.searchKeyword).subscribe(
      (result) => {
        console.log('Réponse de la recherche :', result); // Affichez la réponse dans la console
        this.listeReclamations = result;
      },
      (error) => {
        console.error('Erreur lors de la recherche de réclamations', error);
      }
    );
  }

  trierReclamations() {
    this.ReclamationService.sortReclamations().subscribe(
      (result) => {
        console.log('Réclamations triées :', result);
        // Mettez à jour la liste des réclamations triées ici si nécessaire
        this.listeReclamations = result;
      },
      (error) => {
        console.error('Erreur lors du tri des réclamations', error);
        // Gérez les erreurs ici
      }
    );
  }

  getStatusColor(status: string) {
    if (status === 'en attente ...') {
      return { color: 'red' };
    } else {
      return { color: 'green' };
    }
  }
}
