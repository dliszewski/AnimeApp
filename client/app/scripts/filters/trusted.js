'use strict';

/**
 * @ngdoc filter
 * @name clientApp.filter:trusted
 * @function
 * @description
 * # trusted
 * Filter in the clientApp.
 */
angular.module('clientApp')
  .filter('trusted',['$sce', function ($sce) {
    return function(url) {
      return $sce.trustAsResourceUrl(url);
    };
  }]);
