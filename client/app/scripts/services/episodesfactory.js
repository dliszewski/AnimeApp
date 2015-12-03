'use strict';

/**
 * @ngdoc service
 * @name clientApp.EpisodesFactory
 * @description
 * # EpisodesFactory
 * Factory in the clientApp.
 */
angular.module('clientApp')
    .factory('EpisodesFactory', ['$resource', '$http', function ($resource, $http) {
        var factory = {};
        factory.getlatest = function (limit) {
            return $http.get('http://localhost:8080/api/episodes/latest/' + limit);
        };
        factory.episodesForSerie = function (id) {
            return $http.get('http://localhost:8080/api/episodes/latest/' + id);
        };
        factory.crud = function () {
            return $resource('http://localhost:8080/api/episodes/:id', {id: '@id'});
        };
        return factory;
    }]);
