import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicPassComponent } from './public-pass.component';

describe('PublicPassComponent', () => {
  let component: PublicPassComponent;
  let fixture: ComponentFixture<PublicPassComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicPassComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicPassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
