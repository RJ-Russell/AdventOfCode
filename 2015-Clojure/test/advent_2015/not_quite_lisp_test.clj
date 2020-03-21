(ns advent-2015.not-quite-lisp-test
  (:require [clojure.test :refer :all]
            [advent-2015.not-quite-lisp :refer :all]))

(def test-input1 "((()))")
(def test-input2 "()(())))(")

(deftest data->nums-converts-each-paren-to-correct-number
  (is (= '(1 1 1 -1 -1 -1) (data->nums test-input1)))
  (is (= '(1 -1 1 1 -1 -1 -1 -1 1) (data->nums test-input2))))
