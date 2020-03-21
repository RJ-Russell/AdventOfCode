(ns advent-2017.memory-reallocation)

(defn get-largest-block-info
  "Resets largest block index to 0, returns updated block vector and the largest val"
  [blocks]
  (let [largest-val (apply max blocks)
        largest-val-index (.indexOf blocks largest-val)]
    [(assoc blocks largest-val-index 0) largest-val-index largest-val]))

(defn distribute
  [blocks states]
  (let [[new-blocks largest-val-index largest-val] (get-largest-block-info blocks)
         add-by (int (Math/ceil (/ largest-val (count new-blocks))))]
    (loop [index (inc largest-val-index)
           new-blocks new-blocks
           states states]
      (if (= index largest-val-index)
        [(assoc new-blocks index (+ (rem largest-val (count new-blocks)) (get new-blocks index))) states]
        (recur (if (>= (+ index 1) (count new-blocks)) 0 (inc index))
          (assoc new-blocks index (+ (get new-blocks index) add-by))
          (conj states new-blocks))))))

; (distribute [3 5 1 5] {})

