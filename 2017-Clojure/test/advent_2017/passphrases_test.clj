(ns advent-2017.passphrases-test
  (:require [clojure.test :refer :all]
            [advent-2017.passphrases :refer :all]))


(deftest duplicates-test
  (testing "Returns true if there are no duplicates, false otherwise"
    (is (= (unique-row? ["aa" "bb" "cc" "dd" "ee"]) true))
    (is (= (unique-row? ["aa" "bb" "cc" "dd" "aa"]) false))
    (is (= (unique-row? ["aa" "bb" "cc" "dd" "aaa"]) true))))

(deftest anagram-test
  (testing "Returns true if there are no anagrams, false otherwise"
    (is (= (has-anagram? ["abcde" "fghij"]) true))
    (is (= (has-anagram? ["abcde" "xyz" "ecdab"]) false))
    (is (= (has-anagram? ["a" "ab" "abc" "abd" "abf" "abj"]) true))
    (is (= (has-anagram? ["iiii" "oiii" "ooii" "oooi" "oooo"]) true))
    (is (= (has-anagram? ["oiii" "ioii" "iioi" "iiio"]) false))))
