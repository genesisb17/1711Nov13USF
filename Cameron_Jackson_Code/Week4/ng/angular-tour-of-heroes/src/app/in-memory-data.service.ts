import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable()
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const heroes = [
      { id: 1, name: 'Wind Dude' },
      { id: 2, name: 'The Incredible Guy' },
      { id: 3, name: 'Repair Man Man' },
      { id: 4, name: 'Metal-Face Doom' },
      { id: 5, name: 'Spider-Person' },
      { id: 6, name: 'Cat-Man' },
      { id: 7, name: 'Spawn' },
      { id: 8, name: 'Wave Rider' },
      { id: 9, name: 'Silver Surfer' },
      { id: 10, name: 'The Hand' },
      { id: 11, name: 'Crazy Diamond' }
    ];
    return { heroes };
  }

}
