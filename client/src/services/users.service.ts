import { Injectable } from "@angular/core";


@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(private userService:UsersService) { }

}