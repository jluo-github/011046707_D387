import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from 'rxjs';
import {ConfigService} from "./config/service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private httpClient: HttpClient,
              private configService: ConfigService) {
  }

  private baseURL: string = 'http://localhost:8080';

  private getUrl: string = this.baseURL + '/room/reservation/v1/';
  private postUrl: string = this.baseURL + '/room/reservation/v1';
  public submitted!: boolean;
  roomsearch!: FormGroup;
  rooms!: Room[];
  request!: ReserveRoomRequest;
  currentCheckInVal!: string;
  currentCheckOutVal!: string;
  // todo: readme
  englishWelcome!: string;
  frenchWelcome!: string;
  timeZones!: string;


  ngOnInit() {

    // todo: readme
    this.EnglishWelcome();
    this.FrenchWelcome();

    this.ThreeTimeZones();

    this.roomsearch = new FormGroup({
      checkin: new FormControl(' '),
      checkout: new FormControl(' ')
    });


    //     this.rooms=ROOMS;

    const roomsearchValueChanges$ = this.roomsearch.valueChanges;

    // subscribe to the stream
    roomsearchValueChanges$.subscribe(x => {
      this.currentCheckInVal = x.checkin;
      this.currentCheckOutVal = x.checkout;
    });

  }


  onSubmit({value, valid}: { value: Roomsearch, valid: boolean }) {
    this.getAll().subscribe(
      rooms => {
        console.log(Object.values(rooms)[0]);
        this.rooms = <Room[]>Object.values(rooms)[0];
      }
    );
  }


  reserveRoom(value: string) {
    this.request = new ReserveRoomRequest(value, this.currentCheckInVal, this.currentCheckOutVal);

    this.createReservation(this.request);
  }

  createReservation(body: ReserveRoomRequest) {
    let bodyString = JSON.stringify(body); // Stringify payload
    let headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    // let options = new RequestOptions({headers: headers}); // Create a request option

    const options = {
      headers: new HttpHeaders().append('key', 'value'),

    }

    this.httpClient.post(this.postUrl, body, options)
      .subscribe(res => console.log(res));
  }

  /*mapRoom(response:HttpResponse<any>): Room[]{
    return response.body;
  }*/


  getAll(): Observable<any> {


    return this.httpClient.get(
      this.baseURL + '/room/reservation/v1?checkin=' + this.currentCheckInVal + '&checkout=' + this.currentCheckOutVal, {responseType: 'json'});
  }

  // todo: readme
  getEnglishWelcome(): Observable<any> {
    return this.httpClient.get(this.getUrl + "welcome/en", {responseType: 'text'});
  }

  getFrenchWelcome(): Observable<any> {
    return this.httpClient.get(this.getUrl + 'welcome/fr', {responseType: 'text'})
  }

  getTimeZones(): Observable<any> {
    return this.httpClient.get(this.getUrl + 'time', {responseType: 'text'})
  }


  // todo: readme
  EnglishWelcome() {
    this.getEnglishWelcome().subscribe(
      message => {
        // this.englishWelcome = message.englishMessage;
        this.englishWelcome = message;
        console.log('english: ', message);
      });
  }

  FrenchWelcome() {
    this.getFrenchWelcome().subscribe(
      message => {
        // this.frenchWelcome = message.frenchMessage;
        this.frenchWelcome = message;
        console.log('french: ', message);
      });
  }


  ThreeTimeZones(): void {

    this.getTimeZones().subscribe(
      data => {
        this.timeZones = data;
        console.log('Time zones:', this.timeZones)
      }
    );
  }
}


export interface Roomsearch {
  checkin: string;
  checkout: string;
}


export interface Room {
  id: string;
  roomNumber: string;
  price: string;
  links: string;

}

export class ReserveRoomRequest {
  roomId: string;
  checkin: string;
  checkout: string;

  constructor(roomId: string,
              checkin: string,
              checkout: string) {

    this.roomId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }
}

/*
var ROOMS: Room[]=[
  {
  "id": "13932123",
  "roomNumber" : "409",
  "price" :"20",
  "links" : ""
},
{
  "id": "139324444",
  "roomNumber" : "509",
  "price" :"30",
  "links" : ""
},
{
  "id": "139324888",
  "roomNumber" : "609",
  "price" :"40",
  "links" : ""
}
] */

