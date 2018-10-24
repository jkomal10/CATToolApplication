import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetEvaluationOrderComponent } from './set-evaluation-order.component';

describe('SetEvaluationOrderComponent', () => {
  let component: SetEvaluationOrderComponent;
  let fixture: ComponentFixture<SetEvaluationOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetEvaluationOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetEvaluationOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
