(ns advent-2017.captcha)

(def input (clojure.string/trim (slurp "resources/captcha")))
(defn char->int [s] (mapv (fn [x] (Integer/parseInt (str x))) s))
(defn wrap
  [inp]
  (let [list (char->int inp)]
  (conj list (first list))))

(defn part
  [inp] (partition 2 1 inp))

(defn filt [inp]
  "Takes the first element from each tuple where both elements in tuple are equal"
  (map first (filter (fn [t] (= (first t) (second t))) inp)))

(defn split-list
  "Splits the list in half (list assumed to be even length)"
  [list]
  (let [half (/ (count list) 2)]
  (split-at half list)))

(defn split-and-zip
  "Splits the list in half (list assumed to be even length) and zips the resulting tuples"
  [list]
  (let [split (split-list list)]
  (map vector (first split) (second split))))

(defn captcha [inp] (reduce + ((comp filt part wrap char->int) inp)))
(defn captcha2 [inp] (* (reduce + ((comp filt split-and-zip char->int) inp)) 2))
