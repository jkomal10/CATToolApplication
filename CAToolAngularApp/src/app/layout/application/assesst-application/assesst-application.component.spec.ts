import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssesstApplicationComponent } from './assesst-application.component';

describe('AssesstApplicationComponent', () => {
  let component: AssesstApplicationComponent;
  let fixture: ComponentFixture<AssesstApplicationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssesstApplicationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssesstApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
