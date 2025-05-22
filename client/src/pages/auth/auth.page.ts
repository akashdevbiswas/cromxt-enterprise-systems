import { Component } from "@angular/core";
import { Router, RouterOutlet } from "@angular/router";
import { ButtonComponent } from "../../components/button.component";



@Component({
  selector: "auth-page",
  templateUrl: "auth.page.html",
  imports: [RouterOutlet, ButtonComponent],
  standalone: true
})
export class AuthPage {
  constructor(protected router: Router) {}
}