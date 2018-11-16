import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.scss']
})
export class HelpComponent implements OnInit {

  video:string;
  player:YT.Player;
  id:string;
  components:string;
  constructor() { }

  ngOnInit() {
    this.video=localStorage.getItem('component');
    console.log(this.video);
    this.call();

  }

  call()
  {
    // this.player: YT.Player;
    if(this.video=='user'){
      this.components = 'Video for all services of users';
      this.id= '0eWrpsCLMJQ';
    }
    

  //  savePlayer(player) {
  //   this.player = player;
  //   console.log('Video Url', player.getVideoUrl());
  // }
  // onStateChange(event) {
  //   console.log('player state', event.data);
  // }
  }
}
