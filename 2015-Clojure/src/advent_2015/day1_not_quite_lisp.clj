(ns advent-2015.day1-not-quite-lisp)

(def data (slurp "resources/not_quite_lisp_data"))

(defn- data->nums [d]
  (->> d
       (map {\( 1 \) -1})))

(defn part1 [d]
  (->> (data->nums d)
       (reduce +)))

(defn part2 [d]
  (.indexOf (reductions + (data->nums d)) -1))

(defn -main []
  (let [p1 (part1 data)
        p2 (part2 data)]
    (println "Part 1:" p1 "\nPart 2:" p2)))
