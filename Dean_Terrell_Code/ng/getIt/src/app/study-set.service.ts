import { Injectable } from '@angular/core';
import { StudySet } from './studyset';
import { environment } from '../environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';

const API_URL = environment.apiUrl;
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class StudySetService {

 


  constructor(private http: HttpClient) { }

  public getStudySets(){
    return this.http.get<StudySet[]>(API_URL);
  }

  public addStudySet(set: StudySet){
    set.author = 1;
    this.http.post<StudySet>(API_URL + "/addset", set, httpOptions).subscribe();
  }

  public updateStudySet(set: StudySet, amount : number){
    return this.http.patch<StudySet>(API_URL + "/" + set.id, StudySet, httpOptions).subscribe();
  }
}
