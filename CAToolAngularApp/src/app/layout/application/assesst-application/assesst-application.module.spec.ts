import { AssesstApplicationModule } from './assesst-application.module';

describe('AssesstApplicationModule', () => {
  let assesstApplicationModule: AssesstApplicationModule;

  beforeEach(() => {
    assesstApplicationModule = new AssesstApplicationModule();
  });

  it('should create an instance', () => {
    expect(assesstApplicationModule).toBeTruthy();
  });
});
