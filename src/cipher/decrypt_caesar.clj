(ns cipher.decrypt-caesar
  (:require [cipher.helpers :as helper]))


(defn caesar-decrypt
  [text key]
  (apply str (mapv #(helper/shift % (* key -1)) (helper/get-letters text))))