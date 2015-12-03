'use strict';

/**
 * @ngdoc service
 * @name clientApp.SeriesFactory
 * @description
 * # SeriesFactory
 * Factory in the clientApp.
 */
angular.module('clientApp')
  .factory('SeriesFactory', function ($resource) {
    // Service logic
    // ...

    return $resource('http://localhost:8080/api/series/:id');

    // Public API here
    //return {
    //  someMethod: function () {
    //    return meaningOfLife;
    //  }
    //};


  });
