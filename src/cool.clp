(deftemplate Coolness
    (slot cool)
)

(defrule maged_is_cool
    (maged cool)
    =>
    (printout t "obviously yes" crlf)
    (assert (Coolness (cool maged_is_cool)))
)

(defrule maged_isnot_cool
     (maged notcool)
    =>
    (printout t "maged is always cool" crlf)
    (assert (Coolness (cool maged_isnot_cool)))
)



