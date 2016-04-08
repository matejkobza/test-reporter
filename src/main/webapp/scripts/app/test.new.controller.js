'use strict';

angular.module('app')
    .controller('NewTestController', function ($scope, service, $state) {

        var vm = this;
        $scope.onlyNumbers = /^[0-9]+$/;

        vm.test = {
            akt: undefined,
            skupina: undefined,
            kod: undefined,
            nazov: undefined,
            src_sql: undefined,
            trg_sql: undefined,
            oond_sql: undefined,
            popis: undefined,
            src_par: undefined,
            trg_par: undefined
        };

        vm.send = send;
        vm.init = init;

        /**
         * if valid then send data and store them
         */
        function send() {
            if (validate()) {
                service.save(vm.test).then(function (response) {
                    $state.go('tests');
                });
            } else {
                alert("Prosím, opravte zle zadané hodnoty!");
            }
        }

        function validate() {
            return vm.test.akt.length && vm.test.nazov.length;
        }

        function init() {
            service.loadSettings().then(function (response) {
                vm.test.src_par = response.data;
                vm.test.trg_par = response.data;
                console.debug("DEBUG: ", vm.test.src_par);

            });
        }

        init();

    });