import { TestBed, inject } from '@angular/core/testing';

import { EvaluationOrderService } from './evaluation-order.service';

describe('EvaluationOrderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EvaluationOrderService]
    });
  });

  it('should be created', inject([EvaluationOrderService], (service: EvaluationOrderService) => {
    expect(service).toBeTruthy();
  }));
});
