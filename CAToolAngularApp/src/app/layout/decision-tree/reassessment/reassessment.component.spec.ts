import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReassessmentComponent } from './reassessment.component';

describe('ReassessmentComponent', () => {
  let component: ReassessmentComponent;
  let fixture: ComponentFixture<ReassessmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReassessmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReassessmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
