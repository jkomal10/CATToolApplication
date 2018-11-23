import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CATloginComponent } from './catlogin.component';

describe('CATloginComponent', () => {
  let component: CATloginComponent;
  let fixture: ComponentFixture<CATloginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CATloginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CATloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
