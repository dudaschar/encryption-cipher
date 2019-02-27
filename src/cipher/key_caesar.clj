(ns cipher.key-caesar
  (:require [cipher.helpers :as helper]))

(defn count-letters
  [letter text]
  (count (filterv #(= % letter) text)))

(def alphabet (map helper/to-char (range 26)))

(defn hashmap
  [text]
  (zipmap alphabet (mapv #(count-letters % text) alphabet)))

(defn sort-hashmap
  [text]
  (sort-by second > (hashmap text))
  )

(defn popular-letters
  [text]
  (take 3 (sort-hashmap text))
  )

(defn discover-key
  [letter-crypto letter]
  (let [result (- (to-int letter-crypto) (to-int letter))]
    (if (> result 0) result (+ 26 result))))