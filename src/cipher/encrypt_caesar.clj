(ns cipher.encrypt-caesar
  (:require [cipher.helpers :as helper]))


(defn caesar-encrypt
  [text key]
  (apply str (mapv #(helper/shift % key) (helper/get-letters text))))