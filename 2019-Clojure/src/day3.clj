(ns day3
  (:require [clojure.string :refer [split]]))

(def parse-input
  (->
   (slurp "resources/day3_data")
   (split #"\n")))
