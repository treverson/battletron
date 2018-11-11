import { Injectable } from '@angular/core';
import * as Rx from 'rxjs/Rx';

@Injectable()
export class WebsocketService {
  constructor() { }

  private subject: Rx.Subject<MessageEvent>;
  private ws: WebSocket;

  public connect(url): Rx.Subject<MessageEvent> {
    if (!this.subject) {
      this.subject = this.create(url);
      console.log("Successfully connected: " + url);
    }
    return this.subject;
  }

  private create(url): Rx.Subject<MessageEvent> {
    this.ws = new WebSocket(url);

    let observable = Rx.Observable.create(
      (obs: Rx.Observer<MessageEvent>) => {
        this.ws.onmessage = obs.next.bind(obs);
        this.ws.onerror = obs.error.bind(obs);
        this.ws.onclose = obs.complete.bind(obs);
        return this.ws.close.bind(this.ws);
      });

    let observer = {
      next: (data: string) => {
        if (this.ws.readyState === WebSocket.OPEN) {
          this.ws.send(data);
        }
      }
    };

    return Rx.Subject.create(observer, observable);
  }

  public disconnect() {
    this.ws.close();
  }

}
