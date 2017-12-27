import { ChuckNorrisService } from './services/chuck-norris.service';
// modules
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

// components
import {AppComponent} from './app.component';
import {NavComponent} from './components/nav/nav.component';
import {InterpolationComponent} from './components/interpolation/interpolation.component';
import {EventBindingComponent} from './components/event-binding/event-binding.component';
import {PropertyBindingComponent} from './components/property-binding/property-binding.component';
import {FlashcardComponent} from './components/flashcard/flashcard.component';
import {PipesComponent} from './components/pipes/pipes.component';
import {StructuralDirectiveComponent} from './components/structural-directive/structural-directive.component';
import {TwoWayBindingComponent} from './components/two-way-binding/two-way-binding.component';
import {ParentComponent} from './components/parent/parent.component';
import {Child1Component} from './components/child1/child1.component';
import {Child2Component} from './components/child2/child2.component';
import {HttpCachedComponent} from './components/http-cached/http-cached.component';

// services
import {FlashcardService} from './services/flashcard.service';
import { CookieService } from 'ngx-cookie-service';

// pipes
import {CompletedPipe} from './pipes/completed.pipe';


import {appRoutes} from './routes';
import { SuperbarComponent } from './components/superbar/superbar.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes,{useHash:true}),
    FormsModule
  ],
  declarations: [
    // components
    AppComponent,
    NavComponent,
    InterpolationComponent,
    EventBindingComponent,
    PropertyBindingComponent,
    FlashcardComponent,
    PipesComponent,
    StructuralDirectiveComponent,
    TwoWayBindingComponent,
    ParentComponent,
    Child1Component,
    Child2Component,
    HttpCachedComponent,

    // pipes
    CompletedPipe,

    SuperbarComponent,

    LoginComponent,
   ],
  providers: [
     // services
     FlashcardService,
     ChuckNorrisService,
     CookieService
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
