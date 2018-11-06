import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-game-view',
  templateUrl: './game-view.component.html',
  styleUrls: ['./game-view.component.css']
})
export class GameViewComponent implements OnInit {

  @ViewChild('gameViewCanvas') canvasRef: ElementRef;
  private running: boolean;

  constructor(private ngZone: NgZone) {}

  ngOnInit() {
    this.running = true;
    this.ngZone.runOutsideAngular(() => this.paint());
  }

  ngOnDestroy() {
    this.running = false;
  }

  private paint() {
    // Check that we're still running.
    if (!this.running) {
      return;
    }

    // Paint current frame
    let ctx: CanvasRenderingContext2D =
      this.canvasRef.nativeElement.getContext('2d');

    // Draw background (which also effectively clears any previous drawing)
    ctx.fillStyle = 'rgb(221, 0, 49)';
    // Clear any previous content.
    ctx.clearRect(0, 0, 500, 500);

    // Draw the clip path that will mask everything else
    // that we'll draw later.
    ctx.beginPath();
    ctx.moveTo(250, 60);
    ctx.lineTo(63.8, 126.4);
    ctx.lineTo(92.2, 372.6);
    ctx.lineTo(250, 460);
    ctx.lineTo(407.8, 372.6);
    ctx.lineTo(436.2, 126.4);
    ctx.moveTo(250, 104.2);
    ctx.lineTo(133.6, 365.2);
    ctx.lineTo(177, 365.2);
    ctx.lineTo(200.4, 306.8);
    ctx.lineTo(299.2, 306.8);
    ctx.lineTo(325.2, 365.2);
    ctx.lineTo(362.6, 365.2);
    ctx.lineTo(250, 104.2);
    ctx.moveTo(304, 270.8);
    ctx.lineTo(216, 270.8);
    ctx.lineTo(250, 189);
    ctx.lineTo(284, 270.8);
    ctx.clip('evenodd');

    // Draw 50,000 circles at random points
    ctx.beginPath();
    ctx.fillStyle = '#DD0031';
    for (let i=0 ; i < 50000 ; i++) {
      let x = Math.random() * 500;
      let y = Math.random() * 500;
      ctx.moveTo(x, y);
      ctx.arc(x, y, 1, 0, Math.PI * 2);
    }
    ctx.fill();

    // Schedule next
    requestAnimationFrame(() => this.paint());
  }

}
