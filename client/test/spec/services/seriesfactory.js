'use strict';

describe('Service: SeriesFactory', function () {

  // load the service's module
  beforeEach(module('clientApp'));

  // instantiate service
  var SeriesFactory;
  beforeEach(inject(function (_SeriesFactory_) {
    SeriesFactory = _SeriesFactory_;
  }));

  it('should do something', function () {
    expect(!!SeriesFactory).toBe(true);
  });

});
