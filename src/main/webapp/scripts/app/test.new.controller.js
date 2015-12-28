'use strict';

angular.module('app')
    .controller('NewTestController', function ($scope, service, $state) {
        // tu je controller ktory sluzi pre formular
        // pridaju sa dake modelove properties v ktorych budu ulozene hodnoty
        // pomocou service case hodnot, treba v service pridat REST volanie
        var vm = this;

        vm.test = {
            akt : undefined,
            skupina: undefined,
            kod: undefined,
            nazov: undefined,
            src_sql: undefined,
            trg_sql: undefined,
            oond_sql: undefined,
            popis: undefined,
            src_par: undefined,
            trg_par: undefined
        }

        vm.send = function() {
            service.save(vm.test).then(function(response) {
                // if resp
                // state.go('tests')
                // else alert error
                $state.go('tests');
            })
        }
    });