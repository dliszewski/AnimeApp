'use strict';

/**
 * @ngdoc overview
 * @name clientApp
 * @description
 * # clientApp
 *
 * Main module of the application.
 */
angular
  .module('clientApp', [
    'ngAnimate',
    'ngResource',
    'ngRoute',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/episode.html',
        controller: 'EpisodeCtrl',
        controllerAs: 'about'
      })
      .when('/episode/:id', {
        templateUrl: 'views/episode.html',
        controller: 'EpisodeCtrl',
        controllerAs: 'about'
      })
      .when('/serie/:id', {
        templateUrl: 'views/serie.html',
        controller:'SerieCtrl'
      })
      .when('/serieslist', {
        templateUrl: 'views/serieslist.html',
        controller:'SerieslistCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
