(ns advent-2017.captcha_test
  (:require [clojure.test :refer :all]
            [advent-2017.captcha :refer :all]))

; PART 1 TESTS
(deftest char->int-test
  (testing "Take string and return list of ints"
    (is (= [1 2 3] (char->int "123")))
    (is (= [1 2 3 3 3 4 4 1] (char->int "12333441")))
    (is (= [1 2 3 8 4 1 0] (char->int "1238410")))))


(deftest wrap-test
  (testing "First element in list is copied to end of the list"
    (is (= [1 2 3 1] (wrap (char->int "123"))))))

(deftest part-test
  (testing "Partition the elements in list into groups of two"
  (is (= '((1 2) (2 3) (3 1)) (part (wrap (char->int "123")))))
  (is (= '((1 2) (2 3) (3 3) (3 3) (3 4) (4 4) (4 1) (1 1)) (part (wrap (char->int "12333441")))))))

(def testinput1 (part (wrap (char->int "12333441"))))
(deftest filt-test
  (testing "Filters out numbers equal to the next number"
    (is (= '(3 3 4 1) (filt testinput1)))))

(deftest captcha-test
  (testing "Produces correct sum when given a list (as per problem 1 examples)"
    (is (= (captcha "") 0))
    (is (= (captcha "1122") 3))
    (is (= (captcha "1111") 4))
    (is (= (captcha "1234") 0))
    (is (= (captcha "91212129") 9))))


; PART 2 TESTS
(deftest split-list-test
  (testing "split even length list in half"
    (is (= (split-list '[1 2 3 4]) '[(1 2) (3 4)]))))

(deftest split-and-zip-test
  (testing "Splits the list and zips the resulting tuples"
    (is (= (split-and-zip [1 2 3 4]) '[(1 3) (2 4)]))
    (is (= (split-and-zip [1 2 3 4 1 2 3 4]) '[(1 1) (2 2) (3 3) (4 4)]))))

(deftest captcha2-test
  (testing "Produces correct sum when given a list (as per problem 2 examples)"
    (is (= (captcha2 "1212") 6))
    (is (= (captcha2 "1221") 0))
    (is (= (captcha2 "123425") 4))
    (is (= (captcha2 "123123") 12))
    (is (= (captcha2 "12131415")))))
