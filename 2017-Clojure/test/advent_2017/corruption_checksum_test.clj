(ns advent-2017.corruption_checksum_test
  (:require [clojure.test :refer :all]
            [advent-2017.corruption_checksum :refer :all]))

; Day 2 - Part 1 Tests
(deftest parse-rows-test
  (testing "Given a string with newlines, splits the string on the newlines"
    (is (= '["123" "234"] (parse-rows "123\n234")))
    (is (= '["123" "234" "345"] (parse-rows "123\n234\n345")))
    (is (= '["123 234 345" "234 345 123" "345 234 123"] (parse-rows "123 234 345\n234 345 123\n345 234 123")))))


(deftest parse-lines-test
  (testing "Given a string with whitespace, splits on the white space, converts the string number to an int"
    (is (= '([123 234]) (parse-lines ["123 234"])))))

(deftest diff-test
  (testing "Returns the difference of the max and min in a list"
    (= 3 (diff '[1 2 3]))
    (= 4 (diff '[5 1 9 5]))))

(deftest parse-and-diff-test
  (testing "Parses input file and maps the diff function over each sublist"
    (is (= (parse-and-diff "1 2 3\n3 4 5\n4 5 6") '(2 2 2)))
    (is (= (parse-and-diff "4 3 7\n10 23 9\n34 2 1") '(4 14 33)))))

(deftest checksum1-test
  (testing "Calculates sum of the diff of each sublist"
    (is (= (checksum1 "4 3 7\n10 23 9\n34 2 1") 51))
    (is (= (checksum1 "5 1 9 5\n7 5 3\n2 4 6 8") 18))))


; Day 2 - Part 2 Tests
(deftest div-test
  (testing "Calculates the result of the values that are evenly divisible"
    (is (= (div [2 3 4]) 2))
    (is (= (div [23 99 177 69]) 3))))

(deftest checksum2-test
  (testing "Calculates sum of the div results for each sublist"
    (is (= (checksum2 "5 9 2 8\n9 4 7 3\n3 8 6 5") 9))))
