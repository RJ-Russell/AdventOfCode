(ns day1-test
  (:require
   [clojure.test :refer [deftest is]]
   [day1 :as d1]))


(deftest calculate-fuel-returns-correct-value-based-on-mass
  (is (= 2 (d1/mass->fuel 12)))
  (is (= 2 (d1/mass->fuel 14)))
  (is (= 654 (d1/mass->fuel 1969)))
  (is (= 33583 (d1/mass->fuel 100756))))

(deftest returns-correct-list-of-fuel-subvalues
  (is (= [2] (d1/fuel-per-module 14)))
  (is (= [654 216 70 21 5] (d1/fuel-per-module 1969))))

(deftest returns-correct-total-fuel-per-module
  (is (= 2 (d1/total-fuel-per-module 14)))
  (is (= 966 (d1/total-fuel-per-module 1969)))
  (is (= 50346 (d1/total-fuel-per-module 100756))))