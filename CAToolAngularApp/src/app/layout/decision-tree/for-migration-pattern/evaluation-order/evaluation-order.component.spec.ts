import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EvaluationOrderComponent } from './evaluation-order.component';

describe('EvaluationOrderComponent', () => {
  let component: EvaluationOrderComponent;
  let fixture: ComponentFixture<EvaluationOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EvaluationOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EvaluationOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
