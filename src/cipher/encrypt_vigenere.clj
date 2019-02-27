(ns cipher.encrypt-vigenere
  (:require [cipher.helpers :as helper]))

(defn vigenere-encrypt
  [text key-word]
  (let [key-text (cycle key-word) new-text (helper/get-letters text)]
    (apply str (mapv #(helper/encrypt-letter %1 %2) key-text new-text))))