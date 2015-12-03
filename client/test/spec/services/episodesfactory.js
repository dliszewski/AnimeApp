'use strict';

describe('Service: EpisodesFactory', function () {

  // load the service's module
  beforeEach(module('clientApp'));

  // instantiate service
  var EpisodesFactory;
  beforeEach(inject(function (_EpisodesFactory_) {
    EpisodesFactory = _EpisodesFactory_;
  }));

  it('should do something', function () {
    expect(!!EpisodesFactory).toBe(true);
  });

});
