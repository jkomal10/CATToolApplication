import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForCloudableComponent } from './for-cloudable.component';

describe('ForCloudableComponent', () => {
  let component: ForCloudableComponent;
  let fixture: ComponentFixture<ForCloudableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForCloudableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForCloudableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
