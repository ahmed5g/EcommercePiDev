import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReclamationService {

  constructor(private httpClient: HttpClient) { }


  GetAllReclamation()
  {
      return this.httpClient.get<[]>('http://localhost:8088/ReclamationC/reclamations');
  }

  AddReclamation(etu : any):Observable<any> 
  {
  
    return this.httpClient.post('http://localhost:8088/ReclamationC/add-reclamation',etu )
  }

  updateReclamation(reclamation: any): Observable<any> {
    const url = 'http://localhost:8088/ReclamationC/updateReclamation';
    return this.httpClient.put(url, reclamation);
  }

  searchReclamation(query: string): Observable<any[]> {
    // Utilisez la requête HTTP appropriée pour la recherche
    const url = `http://localhost:8088/ReclamationC/search?keyword=${query}`;
    return this.httpClient.get<any[]>(url);
  }

  sortReclamations(): Observable<any> {
    const url = 'http://localhost:8088/ReclamationC/sortReclamations';
    return this.httpClient.get(url);
  }

}
