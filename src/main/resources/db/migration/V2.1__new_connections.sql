insert into Connections (from_place, to_place, valid_from, valid_to)
values (
    'Krakow',
    'Katowice',
    TO_DATE('1900/01/01 00:00:00', 'yyyy/mm/dd hh24:mi:ss'),
    TO_DATE('2900/01/01 00:00:00', 'yyyy/mm/dd hh24:mi:ss')
);